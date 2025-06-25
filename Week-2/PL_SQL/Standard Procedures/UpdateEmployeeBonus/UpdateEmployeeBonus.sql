SET SERVEROUTPUT ON SIZE UNLIMITED;

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
  p_dept IN VARCHAR2,
  p_bonus_pct IN NUMBER
) AS
BEGIN
  FOR rec IN (
    SELECT EmployeeID, Salary, Department
    FROM Employees
    WHERE Department = p_dept
    FOR UPDATE
  ) LOOP
    DECLARE
      v_old_salary NUMBER := rec.Salary;
      v_new_salary NUMBER := rec.Salary * (1 + p_bonus_pct / 100);
    BEGIN
      UPDATE Employees
      SET Salary = v_new_salary
      WHERE EmployeeID = rec.EmployeeID;
      
      DBMS_OUTPUT.PUT_LINE(
        'EmpID: ' || rec.EmployeeID ||
        ' | Dept: ' || rec.Department ||
        ' | Old Salary: ' || TO_CHAR(v_old_salary, 'FM999,990.00') ||
        ' | New Salary: ' || TO_CHAR(v_new_salary, 'FM999,990.00')
      );
    END;
  END LOOP;

  COMMIT;
END UpdateEmployeeBonus;
/
