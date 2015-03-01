/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.servlet;

import fr.upem.easypdm.dao.implement.ParagraphDAO;
import fr.upem.easypdm.entity.Element;
import fr.upem.easypdm.entity.Paragraph;
import fr.upem.easypdm.entity.Users;
import fr.upem.security.EntityType;
import fr.upem.security.Operation;
import fr.upem.security.RAC;
import fr.upem.security.RACs;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Denis
 */
public class DownloadServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    
    @EJB
    private ParagraphDAO paraDAO;
    //PARAM : e_id=1
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Users user = (Users) req.getSession().getAttribute("userSession");
        
        if(user == null) {
            resp.sendRedirect("/EasyPDM/connection.html");
            return;
        }
        
        Long element_id;
        try {
            element_id = Long.parseLong(req.getParameter("e_id"));
        }
        catch(Exception e) {
            resp.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE);
            return;
        }

       Paragraph paragraph = paraDAO.find(element_id);
        
        if(paragraph == null) {
            resp.sendError(HttpServletResponse.SC_PRECONDITION_FAILED);
            return;
        }
        
        RAC rac = new RACs(user.getUseRoles());
        
        if(!rac.isPermitOperation(EntityType.PARAGRAPH, Operation.READ, paragraph)) {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        
        /* Récupération du chemin du fichier demandé au sein de l'URL de la requête */
        /*String filename = req.getPathInfo().replace("/", "");
        if ( filename == null || "/".equals( filename ) ) {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }*/

        /*
        ServletContext context = req.getServletContext();
        Path tmpDir = Paths.get(context.getInitParameter("DOWNLOAD_DIR"));
        Path tmpFile = tmpDir.resolve("test.txt");*/
        
        Path tmpFile = Paths.get(paragraph.getPath());
        File data = tmpFile.toFile();
        
        String type = getServletContext().getMimeType( data.getName() );
        if ( type == null ) {
            type = "application/octet-stream";
        }
        int bufferSize = 64*1024;
        resp.reset();
        resp.setContentType(type);
        resp.setBufferSize( bufferSize );
        resp.setContentType( type );
        resp.setHeader( "Content-Length", String.valueOf( data.length() ) );
        resp.setHeader( "Content-Disposition", "attachment; filename=\"" + data.getName() + "\"" );

        try(BufferedInputStream in = new BufferedInputStream( new FileInputStream( data ),bufferSize);
        BufferedOutputStream out = new BufferedOutputStream( resp.getOutputStream(), bufferSize)) {
            byte[] buffer = new byte[bufferSize];
            int length;
            while ( ( length= in.read( buffer ) ) > 0 ) {
                out.write( buffer, 0, length );
            }
        } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
        }
    }
  
}
