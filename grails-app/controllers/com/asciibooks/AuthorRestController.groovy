package com.asciibooks

import grails.rest.RestfulController

class AuthorRestController extends RestfulController<Author> {
    static responseFormats = ['json']

    AuthorRestController () {
        super(Author)
    }
}