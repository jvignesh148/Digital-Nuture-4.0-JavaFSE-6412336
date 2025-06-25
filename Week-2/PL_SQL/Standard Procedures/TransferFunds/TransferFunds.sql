SET SERVEROUTPUT ON SIZE UNLIMITED;

CREATE OR REPLACE PROCEDURE TransferFunds (
  u_AccountID    IN NUMBER,
  AmountTransfer IN NUMBER
) AS
	v_newDate DATE := SYSDATE;
	v_newBalance NUMBER;
	V_oldBalance NUMBER;
BEGIN
	SELECT Balance 
	 INTO v_oldBalance 
	 FROM Accounts 
	where AccountId=u_AccountID
	  FOR UPDATE;
	
	IF v_oldBalance >= AmountTransfer THEN
		v_newBalance := v_oldBalance - AmountTransfer;

		UPDATE Accounts
            SET Balance = v_newBalance,
		    	LastModified=  v_newDate 
            WHERE AccountID = u_AccountID;
		
		Insert into Transactions(TransactionID,AccountID,TransactionDate,Amount,TransactionType) 						
        values(3,u_AccountID,v_newDate,AmountTransfer,'Withdrawal');
		
		DBMS_OUTPUT.PUT_LINE(
			'Account ID : ' || u_AccountID ||
			' | Amount Transfer=' || AmountTransfer ||
			' | Old Balance=' || v_oldBalance ||
			' | New Balance=' || v_newBalance  
		);
	ELSE
    	DBMS_OUTPUT.PUT_LINE(
      		'Insufficient funds: AccountID=' || u_AccountID ||
      		' | Balance=' || v_oldBalance ||
      		' | Attempted Transfer=' || AmountTransfer
    	);
END IF;
  COMMIT;

EXCEPTION
	WHEN NO_DATA_FOUND THEN
    DBMS_OUTPUT.PUT_LINE('Account not found: ' || u_AccountID);

END TransferFunds;
/
