package com.example;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;


public class App 
{
    public static void main( String[] args ) throws IOException
    {
        Alunno a = new Alunno("Claudio", "Benvenuti", new Date(1979,9,22));
        Alunno a1 = new Alunno("Claudio", "Benvenuti", new Date(1979,9,22));
        Alunno a2 = new Alunno("Claudio", "Benvenuti", new Date(1979,9,22));
        Alunno a3 = new Alunno("Claudio", "Benvenuti", new Date(1979,9,22));
        XmlMapper xmlMapper = new XmlMapper();
        String s1 = xmlMapper.writeValueAsString(a);
        System.out.println(s1);

        xmlMapper.writeValue(new File("test.xml"), a);

        Alunno b = xmlMapper.readValue(new File("test.xml"), Alunno.class);
        System.out.println(b.cognome);
        System.out.println(b.nome);

        Classe c = new Classe(5,"AIA","04-TC",new ArrayList<Alunno>());
        c.addAlunni(a);
        c.addAlunni(a1);
        c.addAlunni(a2);
        c.addAlunni(a3);

        System.out.println("--XML----");
        xmlMapper.writeValue(new File("test.xml"), c);

        Classe cl1 = xmlMapper.readValue(new File("test.xml"), Classe.class);
        System.out.println(cl1.getNumero());
        System.out.println(cl1.getSezione());
        System.out.println(cl1.getAula());
    }
}