package rafael.sd.handler;

import org.apache.thrift.TException;
import rafael.sd.generated.exception.KeyNotFound;
import rafael.sd.generated.service.ChaveValor;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Optional;

public class ChaveValorHandler implements ChaveValor.Iface {
    HashMap<Integer, String> dict = new LinkedHashMap<Integer, String>();

    public String getKV(int key) throws KeyNotFound, TException {
        return Optional.ofNullable(dict.getOrDefault(key, null)).orElseThrow(KeyNotFound::new);
    }

    public String setKV(int key, String value) throws TException {
        return Optional.ofNullable(dict.put(key, value)).orElse("");
    }

    public void delKV(int key) throws TException {
        dict.remove(key);
    }
}
