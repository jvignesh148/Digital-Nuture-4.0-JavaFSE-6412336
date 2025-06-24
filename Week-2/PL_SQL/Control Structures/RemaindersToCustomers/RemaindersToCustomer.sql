SET SERVEROUTPUT ON;

BEGIN
    FOR rec IN (
        SELECT LoanID,
               CustomerID,
               LoanAmount,
               InterestRate,
               TO_CHAR(StartDate, 'DD-MON-YYYY') AS StartDate,
               TO_CHAR(EndDate, 'DD-MON-YYYY') AS EndDate
        FROM Loans
        ORDER BY LoanID
    ) LOOP
        DBMS_OUTPUT.PUT_LINE(
            'LoanID: '        || rec.LoanID ||
            ', CustomerID: '  || rec.CustomerID ||
            ', Amount: '      || rec.LoanAmount ||
            ', Interest: '    || rec.InterestRate || '%' ||
            ', Start: '       || rec.StartDate ||
            ', End: '         || rec.EndDate
        );
    END LOOP;
END;
/
