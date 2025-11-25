package it.estar.time_counter.utilities;

import it.estar.time_counter.domain.MarkType;
import jakarta.persistence.AttributeConverter;

public class MarkTypeConverter implements AttributeConverter<MarkType, String> {
    @Override
    public String convertToDatabaseColumn(MarkType markType) {
        if (markType == null) return null;
        return markType.name().replace("_", " ");
    }

    @Override
    public MarkType convertToEntityAttribute(String databaseData) {
        if (databaseData == null) return null;
        return MarkType.valueOf(databaseData.replace(" ", "_"));
    }
}
