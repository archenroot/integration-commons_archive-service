package org.archenroot.integration.commons.archive_service.core;

import lombok.Cleanup;
import org.apache.commons.compress.compressors.xz.XZCompressorOutputStream;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.archenroot.integration.commons.archive_service.core.io.StringUtils;
import org.tukaani.xz.LZMA2Options;
import org.tukaani.xz.XZOutputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {



    protected byte[] doCompress(byte[] plain) throws IOException {

        @Cleanup ByteArrayOutputStream bos = new ByteArrayOutputStream();
        @Cleanup XZCompressorOutputStream xz = null;
        try {
            xz = new XZCompressorOutputStream(bos);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            xz.write(plain);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            xz.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bos.toByteArray();
    }

    public static void compress2() throws Exception {
        LZMA2Options options = new LZMA2Options();
        options.setPreset(8);

        Path fileLocation = Paths.get("/tmp/archive/06-Day ahead/_archive/tmp/xz-java/src/LZMAEncDemo.java");
        byte[] data = Files.readAllBytes(fileLocation);

        XZOutputStream xzout = null;
        //File file = new File("c:/newfile.txt");
        //FileOutputStream fop = new FileOutputStream(file);
        //FileOutputStream fos = new FileOutputStream(new File("aaa.xz"));
        OutputStream out = new FileOutputStream("aaa.xz");

        xzout = new XZOutputStream(
                out,
                options );
        int size;

        xzout.write(data);

        //((ByteBuffer) (buf.flip())).asLongBuffer().get(primes);
        //for (long prime : primes) {
        //    System.out.printf("%10d", prime);
        //}
        out.close();
    }



public static void main (String[] args) throws Exception {
    final String regex = "^(19|20)\\d{2}(0?[1-9]|1[012])(0[1-9]|[12]\\d|3[01])_50HzT_pra\\.xls$";
    final String string = "20170820_50HzT_pra.xls";
    System.out.println("Result: " + StringUtils.matchString(string,regex));

    //compress2();

    /**
     * Testing init of data
     */

    DataGenerator dataGenerator = new DataGenerator();



}

    void prepareData(){
        // Delete temporary folder


        // Copy data from backup

    }
}
