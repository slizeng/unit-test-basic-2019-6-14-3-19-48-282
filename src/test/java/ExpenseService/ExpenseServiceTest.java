package ExpenseService;

import ExpenseService.Exception.UnexpectedProjectTypeException;
import ExpenseService.Expense.ExpenseType;
import ExpenseService.Project.Project;
import ExpenseService.Project.ProjectType;
import org.junit.jupiter.api.Test;

import static ExpenseService.ExpenseService.getExpenseCodeByProjectTypeAndName;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ExpenseServiceTest {
    @Test
    void should_return_internal_expense_type_if_project_is_internal() {
        Project internalProject = new Project(ProjectType.INTERNAL, "project name");

        ExpenseType expenseType = getExpenseCodeByProjectTypeAndName(internalProject);

        assertEquals(ExpenseType.INTERNAL_PROJECT_EXPENSE, expenseType);
    }

    @Test
    void should_return_expense_type_A_if_project_is_external_and_name_is_project_A() {
        Project externalProject = new Project(ProjectType.EXTERNAL, "Project A");

        ExpenseType expenseType = getExpenseCodeByProjectTypeAndName(externalProject);

        assertEquals(ExpenseType.EXPENSE_TYPE_A, expenseType);
    }

    @Test
    void should_return_expense_type_B_if_project_is_external_and_name_is_project_B() {
        Project externalProject = new Project(ProjectType.EXTERNAL, "Project B");

        ExpenseType expenseType = getExpenseCodeByProjectTypeAndName(externalProject);

        assertEquals(ExpenseType.EXPENSE_TYPE_B, expenseType);
    }

    @Test
    void should_return_other_expense_type_if_project_is_external_and_has_other_name() {
        Project externalProject = new Project(ProjectType.EXTERNAL, "other name");

        ExpenseType expenseType = getExpenseCodeByProjectTypeAndName(externalProject);

        assertEquals(ExpenseType.OTHER_EXPENSE, expenseType);
    }

    @Test
    void should_throw_unexpected_project_exception_if_project_is_invalid() {
        Project unexpectedProject = new Project(ProjectType.UNEXPECTED_PROJECT_TYPE, "any name");
        Project nullProject = new Project(null, "any name");

        assertThrows(UnexpectedProjectTypeException.class,
                () -> getExpenseCodeByProjectTypeAndName(unexpectedProject));
        assertThrows(UnexpectedProjectTypeException.class,
                () -> getExpenseCodeByProjectTypeAndName(nullProject));
    }
}