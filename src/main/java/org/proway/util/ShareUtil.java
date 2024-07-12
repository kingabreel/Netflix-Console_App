package org.proway.util;

import org.proway.util.annotations.Doc;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class ShareUtil {

    @Doc(author = "Caique Bezerra", date = "12/07/2024", version = "1.0", description = "Copy a link to the clipboard and print a message to the console")
    public static void shareLink(String link) {
        StringSelection selection = new StringSelection(link);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, selection);
        System.out.println("Link copied to clipboard");

//        shareLink("https://newlink.com");
    }
}