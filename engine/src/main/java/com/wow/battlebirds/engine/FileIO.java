package com.wow.battlebirds.engine;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by ChrisH on 22/02/14.
 */
public interface FileIO {

    public InputStream readFile(String file) throws IOException;

    public OutputStream writeFile(String file) throws IOException;
}
