/*
 * Copyright 1992-2016 The Tech Garage Project. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted 
 * provided that the following conditions are met:
 *
 *   1. Redistributions of source code must retain the above copyright notice, this list of 
 *      conditions and the following disclaimer.
 *   2. Redistributions in binary form must reproduce the above copyright notice, this list of 
 *      conditions and the following disclaimer in the documentation and/or other materials 
 *      provided with the distribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR AND CONTRIBUTORS ``AS IS'' AND ANY EXPRESS OR IMPLIED 
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND 
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE AUTHOR OR CONTRIBUTORS 
 * BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES 
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, 
 * OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN 
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT 
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package io.techgarage;

import java.io.IOException;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        final String command = args[0];

        Stream<ProcessHandle> processStream = null;

        if ("ps".equals(command)) {
            processStream = ProcessHandle.allProcesses();
        } else if ("children".equals(command)) {
            processStream = ProcessHandle.of(Long.valueOf(args[1])).get().children();
        } else if ("descendants".equals(command)) {
            processStream = ProcessHandle.of(Long.valueOf(args[1])).get().descendants();
        }

        if (processStream != null) {
            processStream.forEach(Main::showInfo);
        } else {
            throw new IllegalArgumentException();
        }
    }

    private static void showInfo(ProcessHandle processHandle) {
        System.out.println("PID: " + processHandle.getPid() + " Command: " + processHandle.info().command().orElse("N/A"));
    }
}
