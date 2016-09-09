package io.techgarage;

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
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;
import org.yaml.snakeyaml.Yaml;

public class CyborgTest {

    @Test
    public void testSerialization() throws Exception {
        InetAddress ip = InetAddress.getByName("::1"); // IPv6 loopback address

        Weapon primary = new Weapon(10, "m4a1");
        Weapon sidearm = new Weapon(6, "glock");
        Collection<Weapon> weapons = new ArrayList<>();
        weapons.add(primary);
        weapons.add(sidearm);

        Cyborg cyborg = new Cyborg(UUID.randomUUID(), "TG-1000", ip, weapons);

        Yaml yamlProcessor = new Yaml(new ApplicationConstructor(), new ApplicationRepresenter());
        String yaml = yamlProcessor.dump(cyborg);

        System.out.println(yaml);

        Cyborg cyborgCopy = yamlProcessor.loadAs(yaml, Cyborg.class);

        Assert.assertFalse(cyborg == cyborgCopy);
        Assert.assertEquals(cyborg, cyborgCopy);
    }
}
