package rafael.sd.application;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;
import rafael.sd.generated.service.ChaveValor;
import rafael.sd.handler.ChaveValorHandler;

public class ChaveValorServer {
    public static void main(String[] args) throws TTransportException {
        ChaveValorHandler handler = new ChaveValorHandler();
        var processor = new ChaveValor.Processor(handler);

        TServerTransport serverTransport = new TServerSocket(9090);
        TServer server = new TSimpleServer(new TServer.Args(serverTransport).processor(processor));
        System.out.println("Starting the simple server...");
        server.serve();
    }
}
