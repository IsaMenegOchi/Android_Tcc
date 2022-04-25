package com.example.tcc_after.remote;

import com.example.tcc_after.model.Cep;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class ConsumeXML {

    public static List<Cep> xmlDatas(String content){
        try{
            boolean dadosNaTAG = false;
            String tagAtual= "";
            Cep cep = null;
            List<Cep> cepList = new ArrayList<>();

            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xmlPullParser = factory.newPullParser();
            xmlPullParser.setInput(new StringReader(content));

            int eventType = xmlPullParser.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT){
                switch (eventType){
                    case XmlPullParser.START_TAG:
                        tagAtual = xmlPullParser.getName();
                        if (tagAtual.endsWith("xmlcep")){
                            dadosNaTAG = true;
                            cep = new Cep();
                            cepList.add(cep);
                        }
                    break;
                    case XmlPullParser.END_TAG:
                        if (xmlPullParser.getName().equals("xmlcep")){
                            dadosNaTAG = false;
                        }
                        tagAtual = "";
                        break;

                    case XmlPullParser.TEXT:
                        if (dadosNaTAG && cep != null){
                            switch (tagAtual){
                                case "cep":
                                    cep.setCep(xmlPullParser.getText());
                                break;

                                case "logradouro":
                                    cep.setLogradroudo(xmlPullParser.getText());
                                    break;

                                case "complemento":
                                    cep.setComplemento(xmlPullParser.getText());
                                    break;

                                case "bairro":
                                    cep.setBairro(xmlPullParser.getText());
                                    break;

                                case "localidade":
                                    cep.setLocalidade(xmlPullParser.getText());
                                    break;

                                case "uf":
                                    cep.setUf(xmlPullParser.getText());
                                    break;

                                case "ibge":
                                    cep.setIbge(xmlPullParser.getText());
                                    break;

                                case "gia":
                                    cep.setGia(xmlPullParser.getText());
                                    break;

                                case "ddd":
                                    cep.setDdd(xmlPullParser.getText());
                                    break;

                                case "siafi":
                                    cep.setSiafi(xmlPullParser.getText());
                                    break;
                            }
                        }
                        break;
                }
                eventType = xmlPullParser.next();
            }
            return cepList;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


}
