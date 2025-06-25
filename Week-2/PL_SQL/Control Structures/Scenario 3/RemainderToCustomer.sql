SET SERVEROUTPUT ON;

DECLARE
  CURSOR due_loans IS
    SELECT 
      l.LoanID,
      l.CustomerID,
      l.EndDate,
      c.Name AS CustomerName
    FROM Loans l
    JOIN Customers c 
      ON l.CustomerID = c.CustomerID
    WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30
    ORDER BY l.EndDate;
    
  v_days_left NUMBER;
BEGIN
  FOR loan_rec IN due_loans LOOP
    v_days_left := loan_rec.EndDate - SYSDATE;
    
    DBMS_OUTPUT.PUT_LINE(
      'Reminder: Customer ' || loan_rec.CustomerName ||
      ' (ID ' || loan_rec.CustomerID || ')' ||
      ' — loan ' || loan_rec.LoanID ||
      ' is due in ' || ROUND(v_days_left) || ' day(s) on ' ||
      TO_CHAR(loan_rec.EndDate, 'DD-MON-YYYY')
    );
  END LOOP;
END;
/