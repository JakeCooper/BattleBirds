package com.wow.battlebirds.engine;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;

/**
 * Created by ChrisH on 22/02/14.
 */
public class AndroidIO implements FileIO
{

    Context context;

    public AndroidIO(Context context)
    {
        this.context = context;
    }

    public InputStream readFile(String file) throws IOException
    {
        return new FileInputStream(file);
    }

    public OutputStream writeFile(String file) throws IOException
    {
        return new FileOutputStream(file);
    }
}
