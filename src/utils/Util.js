const snek = require('snekfetch');

module.exports = {
    colour: () => 6308134,
    format: (time) => {
        const methods = [
            { name: 'd', count: 86400 },
            { name: 'h', count: 3600 },
            { name: 'm', count: 60 },
            { name: 's', count: 1 }
          ];
      
          const timeStr = [Math.floor(time / methods[0].count).toString() + methods[0].name];
          for (let i = 0; i < 3; i++) {
            timeStr.push(Math.floor(time % methods[i].count / methods[i + 1].count).toString() + methods[i + 1].name);
          }
          return timeStr.join(', ');
    },
    loadEris: (Eris) => { // Credits to Aether
        const MessageCollector = require('./MessageCollector');

        Object.defineProperty(Eris.Channel.prototype, 'awaitMessages', {
            value: (bot, filter, options) => {
                const collector = new MessageCollector(bot, this, filter, options);
                return new Promise(res => {
                    collector.on('end', (...args) => res(args));
                });
            }
        });

        return Eris;
    },
    codeblock: (lang, str) => {
        return `${'```'}${lang || ''}\n${str}\n${'```'}`;
    },
    cooldown: new Set(),
    helpDesc: (bot) => {
        return `To use my commands do \`${bot.config.prefix}<command>\` or \`@Yui Hirasawa#0629 <command>\`\nTo get extended help, do \`${bot.config.prefix}help [command]\` or \`@Yui Hirasawa#0629 help [command]\``;
    },
    trimArray: (array, maxLen = 10) => {
        if (array.length > maxLen) {
			const len = array.length - maxLen;
			array = array.slice(0, maxLen);
			array.push(`${len} more...`);
		}
		return array;
    }
};