import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyServiceTest {
    @Test
    public void testExternalApi() {
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("Mocked Response");
        MyService service = new MyService(mockApi);
        String result = service.fetchData();
        assertEquals("Mocked Response", result);
    }
}