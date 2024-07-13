package com.oracle.servlet.backend;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/backend/captServlet")
public class CaptServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("image/jpeg");


		response.setHeader("pragma", "no-cache");

		response.setHeader("cache-control", "no-cache");

		response.setHeader("expires", "0");


		int length = 4;

		String valcode = "";

		Random rd = new Random();

		for (int i = 0; i < length; i++)

			valcode += rd.nextInt(10);


		HttpSession session = request.getSession();

		session.setAttribute("valcode", valcode);
		//用session对验证码做了保存


		int width = 80;

		int height = 25;

		BufferedImage img = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);


		Graphics g = img.getGraphics();


		g.setColor(Color.WHITE);

		g.fillRect(0, 0, width, height);


		for (int i = 0; i < 50; i++) {

			g.setColor(new Color(rd.nextInt(100) + 155, rd.nextInt(100) + 155,
					rd.nextInt(100) + 155));

			g.drawLine(rd.nextInt(width), rd.nextInt(height),
					rd.nextInt(width), rd.nextInt(height));

		}


		g.setColor(Color.GRAY);

		g.drawRect(0, 0, width - 1, height - 1);


		Font[] fonts = { new Font("隶书", Font.BOLD, 18),
				new Font("楷体", Font.BOLD, 18), new Font("宋体", Font.BOLD, 18),
				new Font("幼圆", Font.BOLD, 18) };

		for (int i = 0; i < length; i++) {

			g.setColor(new Color(rd.nextInt(150), rd.nextInt(150), rd
					.nextInt(150)));

			g.setFont(fonts[rd.nextInt(fonts.length)]);

			g.drawString(valcode.charAt(i) + "", width / valcode.length() * i
					+ 2, 18);

		}


		g.dispose();

		ImageIO.write(img, "jpeg", response.getOutputStream());
	}
	//把页面变为图片流

}
