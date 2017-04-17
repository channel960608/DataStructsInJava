package applications.linear.postfix;

import java.io.PrintWriter;

/**
 * Created by channel on 2017/4/17.
 * StatusKeeper类记录求值器的状态
 */
public class StatusKeeper {
    StringBuffer status;

    public StatusKeeper(){status=new StringBuffer();}
    public void init(){status.setLength(0);}
    void update(String token){status.append(token+" ");}
    String getStatus(){return status.toString();}
    void printStatus(PrintWriter pw){pw.println("    Processed:"+status);}
}
