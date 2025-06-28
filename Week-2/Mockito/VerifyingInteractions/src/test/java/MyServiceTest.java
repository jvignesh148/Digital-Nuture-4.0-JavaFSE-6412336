
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;

public class MyServiceTest {
    @Test
    public void testVerifyInteraction() {
        // Step 1: Create a mock object
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        // Step 2: Stub the mock to return a value (optional, if fetchData uses the result)
        String expectedId = "testId";
        String expectedResult = "mockedResult";
        when(mockApi.getData(expectedId)).thenReturn(expectedResult);

        // Step 3: Call the method with specific arguments
        String result = service.fetchData(expectedId);

        // Step 4: Verify the interaction with specific arguments
        verify(mockApi).getData(expectedId);

        // Step 5: Optional - Assert the result
        assert result.equals(expectedResult) : "Expected result: " + expectedResult + ", but got: " + result;
    }
}