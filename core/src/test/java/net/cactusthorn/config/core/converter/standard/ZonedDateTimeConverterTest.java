/*
* Copyright (C) 2021, Alexei Khatskevich
*
* Licensed under the BSD 3-Clause license.
* You may obtain a copy of the License at
*
* https://github.com/Gmugra/net.cactusthorn.config/blob/main/LICENSE
*
* THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
* AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
* IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
* DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
* FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
* DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
* SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
* CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
* OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
* OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package net.cactusthorn.config.core.converter.standard;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.junit.jupiter.api.Test;

import net.cactusthorn.config.core.converter.Converter;

public class ZonedDateTimeConverterTest {

    static final ZonedDateTime DATE = ZonedDateTime.of(LocalDateTime.of(2016, 3, 10, 8, 11, 33), ZoneId.systemDefault());
    static final Converter<ZonedDateTime> CONVERTER = new ZonedDateTimeConverter();

    @Test public void simple() {
        CONVERTER.convert("2016-03-10T08:11:33Z");
    }

    @Test public void simpleNullParameters() {
        CONVERTER.convert("2016-03-10T08:11:33Z", null);
    }

    @Test public void simpleEmptyParameters() {
        CONVERTER.convert("2016-03-10T08:11:33Z", new String[0]);
    }

    @Test public void complex() {
        CONVERTER.convert("10.03.2016 08:11:33Z", new String[] { "yyyy-MM-dd'T'HH:mm:sszzz", "dd.MM.yyyy' 'HH:mm:sszzz" });
    }

    @Test public void singleParam() {
        CONVERTER.convert("2016-03-10T08:11:33Z", new String[] { "yyyy-MM-dd'T'HH:mm:sszzz" });
    }
}