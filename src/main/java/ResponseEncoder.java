public class ResponseEncoder {


    private byte[] getLoginResponse(byte[] req){
        byte[] b = new byte[4];
        byte[] bResponse = new byte[10];
        b[0] = 0x05;
        b[1] = req[3];
        b[2] = req[req[2] - 6 + 5];
        b[3] = req[req[2] -5 + 5];

        short x = crc16Ccitt(b);
        bResponse[0] = 0x78;
        bResponse[1] = 0x78;
        bResponse[2] = 0x05;
        bResponse[3] = req[3];
        bResponse[4] = req[req[2] - 6 + 5];
        bResponse[5] = req[req[2] -5 + 5];
        bResponse[6] = (byte) ((x >> 8) & 0xff);;
        bResponse[7] = (byte) (x & 0xff);
        bResponse[8] = 0x0D;
        bResponse[9] = 0x0A;
        return bResponse;
    }



    public  short crc16Ccitt(byte[] bytes) {
        int crc = 0xFFFF;          // initial value
        int polynomial = 0x1021;   // 0001 0000 0010 0001 (0, 5, 12)

        for (byte b : bytes) {
            for (int i = 0; i < 8; i++) {
                boolean bit = ((b   >> (7-i) & 1) == 1);
                boolean c15 = ((crc >> 15    & 1) == 1);
                crc <<= 1;
                if (c15 ^ bit) crc ^= polynomial;
            }
        }

        crc &= 0xffff;
        return (short) crc;
    }
}
