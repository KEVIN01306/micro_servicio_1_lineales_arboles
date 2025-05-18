package com.example.micro_servicio_1_lineales_arboles.services;

import guru.nidi.graphviz.attribute.Color;
import guru.nidi.graphviz.attribute.Shape;
import guru.nidi.graphviz.attribute.Style;
import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.model.MutableGraph;
import guru.nidi.graphviz.model.MutableNode;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

import static guru.nidi.graphviz.model.Factory.mutGraph;
import static guru.nidi.graphviz.model.Factory.mutNode;

@Service
public class CreateImageService {

    public String generateListImageBase64(List<String> elementsList) throws IOException {
        MutableGraph graph = mutGraph("graph").setDirected(true);
        for (int i = 0; i < elementsList.size(); i++) {
            String elementName = elementsList.get(i);
            MutableNode node = mutNode(elementName)
                    .add(Shape.RECTANGLE)
                    .add(Style.FILLED)
                    .add(Color.rgb(200, 200, 255));
            graph.add(node);
            if (i > 0) {
                String previousElement = elementsList.get(i - 1);
                graph.add(mutNode(previousElement).addLink(mutNode(elementName)));
            }
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Graphviz.fromGraph(graph)
                .width(800)
                .render(Format.PNG)
                .toOutputStream(outputStream);
        byte[] imageBytes = outputStream.toByteArray();
        return Base64.getEncoder().encodeToString(imageBytes);
    }
}