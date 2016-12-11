package id.sch.smktelkom_mlg.learn.datakpu;

import id.sch.smktelkom_mlg.learn.datakpu.model.Data;

/**
 * Created by LittleFireflies on 10-Dec-16.
 */

public class JSONResponse {
    private String comm;
    private String wilayah;
    private Data data;
    private String cmd;

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getComm() {
        return comm;
    }

    public void setComm(String comm) {
        this.comm = comm;
    }

    public String getWilayah() {
        return wilayah;
    }

    public void setWilayah(String wilayah) {
        this.wilayah = wilayah;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
