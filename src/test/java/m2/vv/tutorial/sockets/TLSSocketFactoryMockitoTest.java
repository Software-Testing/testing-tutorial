package m2.vv.tutorial.sockets;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

public class TLSSocketFactoryMockitoTest {


    /**
     * Test when the edge case when the both supported and enabled protocols are null.
     */
    @Test
    public void preparedSocket_NullProtocols()  {

        TLSSocketFactory f = new TLSSocketFactory();
        SSLSocket socket = mock(SSLSocket.class);

        when(socket.getEnabledProtocols()).thenReturn(null);
        doReturn(null).when(socket).getEnabledProtocols();

        f.prepareSocket(socket);

        verify(socket, never()).setEnabledProtocols(any());
    }

    @Test
    public void typical()  {
        TLSSocketFactory f = new TLSSocketFactory();

        SSLSocket socket = mock(SSLSocket.class);

        when(socket.getSupportedProtocols()).thenReturn(shuffle("SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2"));
        when(socket.getEnabledProtocols()).thenReturn(shuffle("SSLv3", "TLSv1"));

        f.prepareSocket(socket);

        verify(socket).setEnabledProtocols(new String[] {"TLSv1.2", "TLSv1.1", "TLSv1", "SSLv3" });
    }

    private String[] shuffle(String... in) {
        List<String> list = new ArrayList<String>(Arrays.asList(in));
        Collections.shuffle(list);
        return list.toArray(new String[0]);
    }
}
