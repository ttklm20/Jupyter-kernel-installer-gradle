/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017 Spencer Park
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package io.github.spencerpark.jupyter.gradle.installers

import groovy.transform.CompileStatic
import org.gradle.api.Nullable

@CompileStatic
class InstallerParameterSpec {
    public static final String PATH_SEPARATOR = '\0\1'
    public static final String FILE_SEPARATOR = '\0\2'

    enum Type { STRING, FLOAT }

    String name
    String envVar
    @Nullable String description
    @Nullable String defaultValue
    private Type _type = Type.STRING
    @Nullable String listSep
    @Nullable List<String> choices
    @Nullable Map<String, String> aliases

    InstallerParameterSpec(String name, String envVar) {
        this.name = name
        this.envVar = envVar
    }

    Type getType() {
        return this._type
    }

    void setType(Type type) {
        if (type == null)
            type = Type.STRING
        this._type = type
    }

    void usePathSeparator() {
        this.listSep = PATH_SEPARATOR
    }

    void useFileSeparator() {
        this.listSep = FILE_SEPARATOR
    }

    void addChoice(String choice) {
        if (this.choices == null)
            this.choices = []
        this.choices.add(choice)
    }

    void addAlias(String name, String replacement) {
        if (this.aliases == null)
            this.aliases = [:]
        this.aliases.put(name, replacement)
    }
}
