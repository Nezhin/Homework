package Homework1;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private final Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }


    @Override
    public void run() {
        try (
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                DataInputStream in = new DataInputStream(socket.getInputStream())
        ) {
            System.out.printf("Homework1.Client %s connected\n", socket.getInetAddress());
            while (true) {
                String command = in.readUTF();
                if ("upload".equals(command)) {
                    uploading(out, in);
                }

                if ("exit".equals(command)) {
                    System.out.printf("Homework1.Client %s disconnected correctly\n", socket.getInetAddress());
                    break;
                }

                System.out.println(command);
//				out.writeUTF(command);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void uploading(DataOutputStream out, DataInputStream in) throws IOException {
        try {
            File file = new File("src\\server"  + File.separator + in.readUTF());
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(file);

            long size = in.readLong();

            byte[] buffer = new byte[8 * 1024];

            for (int i = 0; i < (size + (buffer.length - 1)) / (buffer.length); i++) {
                int read = in.read(buffer);
                fos.write(buffer, 0, read);
            }
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
