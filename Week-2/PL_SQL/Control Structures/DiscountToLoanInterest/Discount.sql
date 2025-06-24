SET SERVEROUTPUT ON;

DECLARE
    v_age NUMBER;
BEGIN
    FOR rec IN (
        SELECT CustomerID, DOB, LoanInterestRate
        FROM Customers
    ) LOOP
        v_age := FLOOR(MONTHS_BETWEEN(SYSDATE, rec.DOB) / 12);
        
        IF v_age > 60 THEN
            UPDATE Customers
            SET LoanInterestRate = LoanInterestRate - 1,
                LastModified = SYSDATE
            WHERE CustomerID = rec.CustomerID;
        END IF;
    END LOOP;
END;
/
