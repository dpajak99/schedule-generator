package org.example.builders;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TimetableDocumentStructure {
    String fileName;
    List<TimetablePageStructure> pages;


}
