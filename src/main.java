import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by vova5049 on 21.07.16.
 */
public class main
{
    public static void main(String[] args)
            throws IOException, InterruptedException {


        String dvd = "DVD+-RW DS-8A8S";
        ArrayList devList = new ArrayList();
        // ��������� � ������
        // ������ ProcessBuilder,
        // ��� ����� ��������� ��������� ls � ����������� -l /dev
        ProcessBuilder procBuilder = new ProcessBuilder("C:\\Program Files (x86)\\cdrtools\\cdrecord.exe","-scanbus");
        //ProcessBuilder procBuilder = new ProcessBuilder("C:\\Program Files (x86)\\cdrtools\\cdrecord.exe","dev=8,0,0","-eject");


        // �������������� ����������� ����� ������ ��
        // ����������� �����
        procBuilder.redirectErrorStream(true);

        // ������ ���������
        Process process = procBuilder.start();
        // ������ ����������� ����� ������
        // � ������� �� �����
        InputStream stdout = process.getInputStream();
        InputStreamReader isrStdout = new InputStreamReader(stdout);
        BufferedReader brStdout = new BufferedReader(isrStdout);

        String line = null;
        while((line = brStdout.readLine()) != null) {
            //System.out.println(line);
            //System.out.println(line.length());
            if (line.length() >= 45)
            {
                String resultStr = line.substring(24, 39);
                if (resultStr.equals(dvd)) {
                    //System.out.println(resultStr);
                    String dev = line.substring(1, 6);
                    devList.add(dev);
                    //System.out.println(dev);

                }

            }





        }

        // ���� ���� ���������� ��������� ���������
        // � ��������� ���, � ������� ��� ����������� �
        // � ���������� exitVal

        if (devList.isEmpty())
        {}
        else
        {
            for (int i = 0; i<=(devList.size()-1); i++)
            {
                System.out.println(devList.get(i));
            }
        }
        //for ()
        //devList.size()

        int exitVal = process.waitFor();
    }
}
