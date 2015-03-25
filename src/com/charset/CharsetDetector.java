package com.charset;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.mozilla.intl.chardet.nsDetector;
import org.mozilla.intl.chardet.nsICharsetDetectionObserver;
import org.mozilla.intl.chardet.nsPSMDetector;

/**
 * 
 * 
 * 
 * @author $Author$
 * @version $Revision$ $Date$
 */
public class CharsetDetector {

	private boolean found = false;
	private String result;
	private int lang;

	public static void main(String[] args) throws IOException {
		CharsetDetector charDect = new CharsetDetector();
		URL url = new URL("http://www.yohoo.com/");
		String[] probableSet = charDect.detectChineseCharset(url.openStream());
		for (String charset : probableSet) {
			System.out.println(charset);
		}
	}

	public String[] detectChineseCharset(InputStream in) throws IOException {
		lang = nsPSMDetector.CHINESE;
		String[] prob;

		nsDetector det = new nsDetector(lang);

		det.Init(new nsICharsetDetectionObserver() {

			public void Notify(String charset) {
				found = true;
				result = charset;
			}
		});
		BufferedInputStream imp = new BufferedInputStream(in);
		byte[] buf = new byte[1024];
		int len;
		boolean isAscii = true;
		while ((len = imp.read(buf, 0, buf.length)) != -1) {
			if (isAscii)
				isAscii = det.isAscii(buf, len);
			if (!isAscii) {
				if (det.DoIt(buf, len, false))
					break;
			}
		}
		imp.close();
		in.close();
		det.DataEnd();
		if (isAscii) {
			found = true;
			prob = new String[] { "ASCII" };
		} else if (found) {
			prob = new String[] { result };
		} else {
			prob = det.getProbableCharsets();
		}
		return prob;
	}

	public String[] detectAllCharset(InputStream in) throws IOException {
		try {
			lang = nsPSMDetector.ALL;
			return detectChineseCharset(in);
		} catch (IOException e) {
			throw e;
		}
	}
}
