import org.junit.jupiter.api.Test;
import webpdecoderjn.WebPDecoder;

import java.net.URL;

import static webpdecoderjn.WebPDecoder.decode;
import static webpdecoderjn.WebPDecoder.getBytesFromURL;

public class WebpTest {
    @Test
    public void test() {
        try {
            WebPDecoder.init();
            URL url = WebPDecoder.class.getResource("/image/test.webp");
            WebPDecoder.WebPImage image = decode(getBytesFromURL(url));
            boolean expectedResult = image.canvasWidth == 16 && image.canvasHeight == 16
                    && image.frameCount == 2 && image.frames.size() == 2
                    && image.loopCount == 1 && image.frames.get(0).delay == 480
                    && image.frames.get(1).delay == 1280;
            if (!expectedResult) {
                throw new WebPDecoder.WebPDecoderException("Unexpected decode result");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
