package org.multipleton.labs.dto;

import java.util.Set;

public record BookDto(Long id, String title, Long authorId, Set<String> tags) {
}
