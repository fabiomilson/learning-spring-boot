package com.learning.springboot.domain.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor
@JacksonXmlRootElement(localName = "kitchens")
public class XmlWrapperKitchen {

    @NonNull
    @Getter
    @JacksonXmlProperty(localName = "kitchen")
    @JacksonXmlElementWrapper(useWrapping = false)
    private Iterable<Kitchen> kitchens;

}
