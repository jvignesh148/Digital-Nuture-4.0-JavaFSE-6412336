SET SERVEROUTPUT ON;

BEGIN
    for rec in (select CustomerID,Balance from Customers) LOOP
        if rec.Balance>10000 THEN
            UPDATE Customers 
            SET isVIP='Y'
            WHERE CustomerID=rec.CustomerID;
        END IF;
        if rec.Balance<=10000 THEN
            UPDATE Customers 
            SET isVIP='N'
            WHERE CustomerID=rec.CustomerID;
        END IF;
    END LOOP;
    COMMIT;
END;
/