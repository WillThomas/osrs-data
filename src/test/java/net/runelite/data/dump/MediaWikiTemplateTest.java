/*
 * MIT License
 *
 * Copyright (c) 2018 Tomas Slusny
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
package net.runelite.data.dump;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

class MediaWikiTemplateTest
{
	@Test
	void parseInfoboxItem1()
	{
		final String data =
			"{{Infobox Item\n" +
				"|name = Dragon claws\n" +
				"|image = [[File:Dragon claws.png]]\n" +
				"|release = [[5 January]] [[2017]]\n" +
				"|update = Dragon Claws & 3rd Birthday\n" +
				"|members = Yes\n" +
				"|quest = No\n" +
				"|tradeable = Yes\n" +
				"|equipable = Yes\n" +
				"|stackable = No\n" +
				"|high = 123000\n" +
				"|low = 82000\n" +
				"|destroy = Drop\n" +
				"|store = No\n" +
				"|exchange = gemw\n" +
				"|examine = A set of fighting claws.\n" +
				"|weight = 0\n" +
				"}}\n";

		final MediaWikiTemplate template = MediaWikiTemplate.parseWikitext("Infobox Item", data);
		assertNotNull(template);
		assertEquals(123000, (int) template.getInt("high"));
	}

	@Test
	void parseInfoboxItem2()
	{
		final String data =
			"{{Infobox item\n" +
				"|name = Magic shortbow (i)\n" +
				"|image = [[File:Magic shortbow (i).png]]\n" +
				"|release = [[18 September]] [[2014]]\n" +
				"|update = Bounty Hunter\n" +
				"|members = Yes\n" +
				"|tradeable = No\n" +
				"|equipable = Yes\n" +
				"|stackable = No\n" +
				"|quest = No\n" +
				"|low = 640\n" +
				"|high = 960\n" +
				"|store = No\n" +
				"|examine = Short and magical, but still effective.\n" +
				"|weight = 1\n" +
				"|destroy = Drop\n" +
				"}}\n";

		final MediaWikiTemplate template = MediaWikiTemplate.parseWikitext("Infobox Item", data);
		assertNotNull(template);
		assertEquals((int) template.getInt("high"), 960);
	}

	@Test
	void parseInfoboxItem3()
	{
		final String data =
			"{{Infobox Item\n" +
				"|name = Proselyte cuisse\n" +
				"|image = [[File:Proselyte cuisse.png|Proselyte cuisse]]\n" +
				"|release = [[20 September]] [[2006]]\n" +
				"|update = Slug Menace\n" +
				"|members = Yes\n" +
				"|quest = [[The Slug Menace]]\n" +
				"|tradeable = Yes\n" +
				"|equipable = Yes\n" +
				"|stackable = No\n" +
				"|noteable = Yes\n" +
				"|placeholder = Yes\n" +
				"|destroy = Drop\n" +
				"|value = 10000\n" +
				"|store = 10000\n" +
				"|exchange = gemw\n" +
				"|weight = 7.711\n" +
				"|examine = A Proselyte Temple Knight's leg armour.\n" +
				"|id = 9676,20565\n" +
				"}}";

		final MediaWikiTemplate template = MediaWikiTemplate.parseWikitext("Infobox Item", data);
		assertNotNull(template);
	}

	@Test
	void parseInfoboxItem4()
	{
		final String data =
			"{{Infobox Item\n" +
				"|name = Explorer's ring 2\n" +
				"|image = [[File:Explorer's ring 2.png]]\n" +
				"|release = [[5 March]] [[2015]]\n" +
				"|update = Achievement Diaries\n" +
				"|members = Yes\n" +
				"|quest = No\n" +
				"|tradeable = No\n" +
				"|equipable = Yes\n" +
				"|stackable = No\n" +
				"|noteable = No\n" +
				"|placeholder = Yes\n" +
				"|destroy = Drop\n" +
				"|value = 0\n" +
				"|store = No\n" +
				"|weight = 0\n" +
				"|examine = A Lumbridge explorer's ring.\n" +
				"|id = 13126\n" +
				"}}";

		final MediaWikiTemplate template = MediaWikiTemplate.parseWikitext("Infobox Item", data);
		assertNotNull(template);
	}

	@Test
	void parseInfoboxItem5()
	{
		final String data =
			"{{Infobox Item\n" +
				"|version1 = Normal\n" +
				"|version2 = Broken\n" +
				"|name1 = Fighter hat\n" +
				"|name2 = Fighter hat (broken)\n" +
				"|image1 = [[File:Fighter hat.png]]\n" +
				"|image2 = [[File:Fighter hat (broken).png]]\n" +
				"|release1 = [[4 January]] [[2007]]\n" +
				"|release2 = [[21 July]] [[2016]]\n" +
				"|update1 = Barbarian Assault\n" +
				"|update2 = Broken Armour & Open Beta\n" +
				"|members = Yes\n" +
				"|quest = No\n" +
				"|tradeable = No\n" +
				"|equipable1 = Yes\n" +
				"|equipable2 = No\n" +
				"|stackable = No\n" +
				"|noteable = No\n" +
				"|placeholder = Yes\n" +
				"|destroy = Drop\n" +
				"|value1 = 65002\n" +
				"|value2 = 1\n" +
				"|alchable = No\n" +
				"|store1 = 275\n" +
				"|store2 = No\n" +
				"|currency = Honour points in each role; must have also killed [[Penance Queen|Queen]]\n" +
				"|seller = Commander Connad\n" +
				"|weight = 2\n" +
				"|examine1 = A Penance Fighter hat.\n" +
				"|examine2 = A broken Penance Fighter hat.\n" +
				"|id1 = 10548\n" +
				"|id2 = 20507\n" +
				"}}\n";

		final MediaWikiTemplate template = MediaWikiTemplate.parseWikitext("Infobox Item", data);
		assertNotNull(template);
	}

	@Test
	void parseInfoboxBonuses1()
	{
		final String data =
			"{{Infobox Bonuses\n" +
				"|astab = 41\n" +
				"|aslash = 57\n" +
				"|acrush = -4\n" +
				"|amagic = 0\n" +
				"|arange = 0\n" +
				"|dstab = 13\n" +
				"|dslash = 26\n" +
				"|dcrush = 7\n" +
				"|dmagic = 0\n" +
				"|drange = 0\n" +
				"|str = 56\n" +
				"|rstr = 0\n" +
				"|mdmg = 0\n" +
				"|prayer = 0\n" +
				"|caption = A player wearing dragon claws.\n" +
				"|aspeed = 4|slot = 2h\n" +
				"|image = Dragon claws equipped.png{{!}}130px}}\n";

		final MediaWikiTemplate template = MediaWikiTemplate.parseWikitext("Infobox Bonuses", data);
		assertNotNull(template);
		assertEquals(4, (int) template.getInt("aspeed"));
		assertEquals("2h", template.getValue("slot"));
		assertEquals("Dragon claws equipped.png{{!}}130px", template.getValue("image"));
	}

	@Test
	void parseInfoboxBonuses2()
	{
		final String data =
			"{{Infobox Bonuses\n" +
				"|version1 = Uncharged\n" +
				"|version2 = Charged\n" +
				"|image_1 = Dragonfire shield (uncharged) equipped.png{{!}}150px\n" +
				"|image_2 = Dragonfire shield equipped.png{{!}}150px\n" +
				"|astab = 0\n" +
				"|aslash = 0\n" +
				"|acrush = 0\n" +
				"|amagic = -10\n" +
				"|arange = -5\n" +
				"|dstab1 = +20\n" +
				"|dslash1 = +25\n" +
				"|dcrush1 = +22\n" +
				"|dmagic1 = +10\n" +
				"|drange1 = +22\n" +
				"|dstab2 = +70\n" +
				"|dslash2 = +75\n" +
				"|dcrush2 = +72\n" +
				"|dmagic2 = +10\n" +
				"|drange2 = +72\n" +
				"|str = +7\n" +
				"|rstr = 0\n" +
				"|mdmg = 0\n" +
				"|prayer = 0\n" +
				"|slot = Shield\n" +
				"}}";

		final MediaWikiTemplate template = MediaWikiTemplate.parseWikitext("Infobox Bonuses", data);
		assertNotNull(template);
		assertEquals(70, (int) template.getInt("dstab2"));
	}

	@Test
	void parseInfoboxBonuses3()
	{
		final String data =
			"{{Infobox Bonuses\n" +
				"|astab = 0\n" +
				"|aslash = 0\n" +
				"|acrush = 0\n" +
				"|amagic = -21\n" +
				"|arange = -7\n" +
				"|dstab = +33\n" +
				"|dslash = +31\n" +
				"|dcrush = +29\n" +
				"|dmagic = -4\n" +
				"|drange = +31\n" +
				"|str = 0\n" +
				"|rstr = 0\n" +
				"|mdmg = 0\n" +
				"|prayer = +6\n" +
				"|slot = Legs\n" +
				"|image = Proselyte armour equipped.png{{!}}110px\n" +
				"|caption = A player wearing proselyte armour.\n" +
				"}}";

		final MediaWikiTemplate template = MediaWikiTemplate.parseWikitext("Infobox Bonuses", data);
		assertNotNull(template);
		assertEquals((int) template.getInt("prayer"), 6);
	}

	@Test
	void parseInfoboxBonuses4()
	{
		final String data =
			"{{Infobox Bonuses\n" +
				"|image   = \n" +
				"|caption = \n" +
				"|astab   =0 \n" +
				"|aslash  =0 \n" +
				"|acrush  =0 \n" +
				"|amagic  =0 \n" +
				"|arange  =0 \n" +
				"|dstab   =0 \n" +
				"|dslash  =0 \n" +
				"|dcrush  =0 \n" +
				"|dmagic  =0 \n" +
				"|drange  =0 \n" +
				"|str     =0 \n" +
				"|prayer  =+1 \n" +
				"|slot    = ring\n" +
				"|rstr = 0\n" +
				"|mdmg = 0\n" +
				"}}";

		final MediaWikiTemplate template = MediaWikiTemplate.parseWikitext("Infobox Bonuses", data);
		assertNotNull(template);
	}

	@Test
	void parseInfoboxBonuses5()
	{
		final String data =
			"{{Infobox Bonuses|| astab   = +8\n" +
				"| aspeed  = 5\n" +
				"| aslash  = -2\n" +
				"| acrush  = +6\n" +
				"| amagic  = 0\n" +
				"| arange  = 0\n" +
				"| dstab   = 0\n" +
				"| dslash  = +1\n" +
				"| dcrush  = 0\n" +
				"| dmagic  = 0\n" +
				"| drange  = 0\n" +
				"| str     = +9\n" +
				"|rstr = 0\n" +
				"|mdmg = 0\n" +
				"| prayer  = 0\n" +
				"|image = Steel pickaxe equipped.png{{!}}150px\n" +
				"|caption = A player wielding a steel pickaxe.\n" +
				"||slot = Weapon}}";

		final MediaWikiTemplate template = MediaWikiTemplate.parseWikitext("Infobox Bonuses", data);
		assertNotNull(template);
	}

	@Test
	void parseLua()
	{
		final String exchangeInfoData =
			"return {\n" +
				"    itemId     = 13652,\n" +
				"    price      = 83173735,\n" +
				"    last       = 83533604,\n" +
				"    date       = '12:18, November 08, 2018 (UTC)',\n" +
				"    lastDate   = '05:43, November 08, 2018 (UTC)',\n" +
				"    icon       = 'Dragon claws.png',\n" +
				"    item       = 'Dragon claws',\n" +
				"    value      = -205000,\n" +
				"    limit      = nil,\n" +
				"    members    = true,\n" +
				"    category   = nil,\n" +
				"    examine    = 'A set of fighting claws.'\n" +
				"}\n";

		final MediaWikiTemplate exchangeInfo = MediaWikiTemplate.parseLua(exchangeInfoData);
		assertNotNull(exchangeInfo);
		assertEquals((int) exchangeInfo.getInt("value"), -205000);
	}
}