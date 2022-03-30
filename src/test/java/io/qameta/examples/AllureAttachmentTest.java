package io.qameta.examples;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.Test;
import java.nio.charset.StandardCharsets;

/**
 * This is a simple example on how you could add attachments to your Allure Report.
 * Example #1
 * annotatedAttachmentTest()
 * Test annotatedAttachmentTest() uses a method textAttachment with annotation @Attachment which is a part of Allure Framework.
 * 'value' parameter of the annotation defines the name of the attachment you will see in Allure Report UI
 * 'type' defined the mime type of the attachment
 * 'fileExtension' parameter defines the extension of an *-attachment[.ext] file which will be linked to the test result
 * Example #2
 * dynamicAttachmentTest()
 *  Test dynamicAttachmentTest() uses Allure Framework's attachment() method adding the name of attachment you will see in the UI of Allure Report, and the content of the attachment.
 *  In this case the attachment is considered as having primary mime type 'text/plain' and the extension of *-attachment[.ext] will be '.txt'
 * for more information on mime types see here: <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Basics_of_HTTP/MIME_types/Common_types">MIME types</>
 */

public class AllureAttachmentTest {

    @Test
    public void annotatedAttachmentTest() {
        textAttachment("Annotated", "hello, world!");
    }

    @Test
    public void dynamicAttachmentTest() {
        Allure.attachment("Dynamic attachment", "attachment content");
    }

    @Attachment(value = "Annotated attachment [{type}]", type = "text/plain", fileExtension = ".txt")
    public byte[] textAttachment(String type, String content) {
        return content.getBytes(StandardCharsets.UTF_8);
    }

}