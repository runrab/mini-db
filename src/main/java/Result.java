import java.util.Map;

public class Result {
    private Object methods;
    //版本信息
    private String version;
    private Map<String,Map> db;

    public Object getMethods() {
        return methods;
    }

    public void setMethods(Object methods) {
        this.methods = methods;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Map<String, Map> getDb() {
        return db;
    }

    public void setDb(Map<String, Map> db) {
        this.db = db;
    }
}
