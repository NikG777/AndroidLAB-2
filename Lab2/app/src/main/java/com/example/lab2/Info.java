package com.example.lab2;

import java.io.Serializable;

public class Info implements Serializable {
    public String graphic;
    public String name;
    public String helptext;

    Info()
    {

    }
    public String getGraphic() {
        return graphic;
    }

    public String getHelptext() {
        return helptext;
    }

    public String getName() {
        return name;
    }

    public void setGraphic(String graphic) {
        this.graphic = graphic;
    }

    public void setHelptext(String helptext) {
        this.helptext = helptext;
    }

    public void setName(String name) {
        this.name = name;
    }
}
