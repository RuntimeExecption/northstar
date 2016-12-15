package com.yusw.northstar.biz.utils.images;

import com.drew.metadata.Metadata;

import javax.imageio.*;
import javax.imageio.metadata.IIOInvalidTreeException;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.metadata.IIOMetadataNode;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by Administrator on 2016/11/6.
 */
public class BBB {
    private BufferedImage gridImage;
    private void saveGridImage(File output) throws IOException {
        output.delete();
        final String formatName = "png";
        for (Iterator<ImageWriter> iw = ImageIO.getImageWritersByFormatName(formatName); iw.hasNext();) {
            ImageWriter writer = iw.next();
            ImageWriteParam writeParam = writer.getDefaultWriteParam();
            ImageTypeSpecifier typeSpecifier = ImageTypeSpecifier.createFromBufferedImageType(BufferedImage.TYPE_INT_RGB);
            IIOMetadata metadata = writer.getDefaultImageMetadata(typeSpecifier, writeParam);
            if (metadata.isReadOnly() || !metadata.isStandardMetadataFormatSupported()) {
                continue;
            }
            metadata = setDPI(metadata);
            final ImageOutputStream stream = ImageIO.createImageOutputStream(output);
            try {
                writer.setOutput(stream);
                writer.write(metadata, new IIOImage(new BufferedImage(100,100,1), null, metadata), writeParam);
            } finally {
                stream.close();
            }
            break;
        }
    }

    private IIOMetadata setDPI(IIOMetadata metadata) throws IIOInvalidTreeException {

        // for PMG, it's dots per millimeter
  /*      double dotsPerMilli = 1.0 * DPI / 10 / INCH_2_CM;
        IIOMetadataNode horiz = new IIOMetadataNode("HorizontalPixelSize");
        horiz.setAttribute("value", Double.toString(dotsPerMilli));

        IIOMetadataNode vert = new IIOMetadataNode("VerticalPixelSize");
        vert.setAttribute("value", Double.toString(dotsPerMilli));
*/

        IIOMetadataNode lat = new IIOMetadataNode("GPS Latitude");
        lat.setAttribute("value",Double.toString(26.6200042939));
        IIOMetadataNode log = new IIOMetadataNode("GPS Longitude");
        log.setAttribute("value",Double.toString(106.6757104939));


        IIOMetadataNode dim = new IIOMetadataNode("Dimension");
        dim.appendChild(lat);
        dim.appendChild(log);

        IIOMetadataNode root = new IIOMetadataNode("javax_imageio_1.0");
        root.appendChild(dim);

        metadata.mergeTree("javax_imageio_1.0", root);

        return metadata;
    }

    public static void main(String[] args) {
        String fileName = "E:\\test_img\\aaa.JPG";
        BBB b = new BBB();
        try {
            b.saveGridImage(new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
