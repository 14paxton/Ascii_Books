package com.asciibooks

class Author {
    String name
    String penName

    String biography

    Boolean privateProfile = false
    Boolean active = true

    Address address

    Date lastUpdated
    Date dateCreated

    static hasMany = [books: Book]

    static constraints = {
        penName nullable: true
        biography nullable: true
    }

    String getDisplayName() {
        penName ?: name
    }
}