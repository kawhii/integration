package com.carl.framework.core.file;

import org.springframework.web.multipart.MultipartFile;

/**
 * 文件保存策略器
 *
 * @author Carl
 * @date 2016/11/29
 * © 2016 - 2020 , all rights reserved .卡尔工作室
 */
public interface FileSaveStrategy {
    /**
     * 获取基础路径
     *
     * @return
     */
    String getBasePath();

    /**
     * 获取文件编码
     *
     * @return
     */
    String getBusiCode();

    /**
     * 获取生成器
     *
     * @return
     */
    NameGenerator getGenerator();

    /**
     * 真正保存文件逻辑
     * @param basePath 基础路径
     * @param file
     * @return
     * @throws FileSaveException
     */
    FileInfo save(String basePath, MultipartFile file) throws FileSaveException;


    class FileInfo {
        private String fileName;
        private String filePath;
        private MultipartFile source;

        public String getFileName() {
            return fileName;
        }

        public FileInfo setFileName(String fileName) {
            this.fileName = fileName;
            return this;
        }

        public String getFilePath() {
            return filePath;
        }

        public FileInfo setFilePath(String filePath) {
            this.filePath = filePath;
            return this;
        }

        public MultipartFile getSource() {
            return source;
        }

        public FileInfo setSource(MultipartFile source) {
            this.source = source;
            return this;
        }
    }
}
