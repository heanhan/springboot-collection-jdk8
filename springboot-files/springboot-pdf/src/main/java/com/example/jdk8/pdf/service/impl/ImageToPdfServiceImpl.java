package com.example.jdk8.pdf.service.impl;


import com.example.jdk8.pdf.service.ImageToPdfService;
import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhaojh
 * @version 1.0
 * @description TODO
 * @date 2024/11/5 上午11:48
 */
@Slf4j
@Service
public class ImageToPdfServiceImpl implements ImageToPdfService {

    /**
     * @param imagePath 图片路径
     * @param pdfPath   pdf 路径
     * @return void
     * @Desc 将图片转换成pdf 文件
     * @date 2024/11/5 下午2:09
     */
    public void convertImageToPdf(String imagePath, String pdfPath) throws IOException {
        // 读取图片
        BufferedImage image = ImageIO.read(new File(imagePath));
        // 创建一个新的PDF文档
        PDDocument document = new PDDocument();
        // 创建一个A4大小的页面
        PDPage page = new PDPage(PDRectangle.A4);
        document.addPage(page);
        // 将图片转换为PDImageXObject对象
        PDImageXObject pdImage = PDImageXObject.createFromFileByContent(new File(imagePath), document);
        // 开始内容流
        try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
            // 计算图片放置的位置和大小
            float scale = Math.min(page.getMediaBox().getWidth() / image.getWidth(),
                    page.getMediaBox().getHeight() / image.getHeight());
            float width = image.getWidth() * scale;
            float height = image.getHeight() * scale;
            float x = (page.getMediaBox().getWidth() - width) / 2;
            float y = (page.getMediaBox().getHeight() - height) / 2;
            // 在页面上绘制图片
            contentStream.drawImage(pdImage, x, y, width, height);
        }
        // 保存PDF文档
        document.save(pdfPath);
        // 关闭文档
        document.close();
    }
}
