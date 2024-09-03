CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    # RETURN 내에서 파라미터를 수정할 수 없다. SET이나 DECLARE를 사용하자.
    SET N = N - 1;
    RETURN (
        SELECT DISTINCT salary
        FROM Employee
        ORDER BY salary DESC
        LIMIT 1 OFFSET N
    );
END
