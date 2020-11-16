package rafael.sd.application;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rafael.sd.generated.service.ChaveValor;


public class ChaveValorClient {
    private static final Logger logger = LoggerFactory.getLogger(ChaveValorClient.class);

    public static void main(String[] args) {

        try {
            TTransport transport;

            transport = new TSocket("localhost", 9090);
            transport.open();

            TProtocol protocol = new TBinaryProtocol(transport);
            ChaveValor.Client client = new ChaveValor.Client(protocol);

            perform(client);

            transport.close();
        } catch (TException x) {
            x.printStackTrace();
        }
    }

    private static void perform(ChaveValor.Client client) throws TException {

        client.setKV(1, "ONE");
        logger.info("Key {}: {}", 1, client.getKV(1));
        logger.info("Trying to replace {}: Old: {} - New: {}", 1, client.setKV(1, "TWO"), client.getKV(1));
    }
}
