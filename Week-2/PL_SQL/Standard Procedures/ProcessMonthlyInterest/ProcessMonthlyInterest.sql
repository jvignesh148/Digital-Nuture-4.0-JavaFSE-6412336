SET SERVEROUTPUT ON SIZE UNLIMITED;

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
  FOR rec IN (
    SELECT AccountID, Balance
    FROM Accounts
    WHERE AccountType = 'Savings'
    FOR UPDATE
  ) LOOP
    DECLARE
      v_old_balance NUMBER := rec.Balance;
      v_new_balance NUMBER := rec.Balance * 1.01;
    BEGIN
      UPDATE Accounts
      SET Balance = v_new_balance,
          LastModified = SYSDATE
      WHERE AccountID = rec.AccountID;

      DBMS_OUTPUT.PUT_LINE(
        'Account ' || rec.AccountID ||
        ' | Old: ' || TO_CHAR(v_old_balance, 'FM999,990.00') ||
        ' | New: ' || TO_CHAR(v_new_balance, 'FM999,990.00')
      );
    END;
  END LOOP;

  COMMIT;
END ProcessMonthlyInterest;
/
