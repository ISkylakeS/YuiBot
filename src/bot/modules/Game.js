const Games = require('../../assets/Games.json');

module.exports = class GameRotater {
    constructor(bot) {
        this.bot = bot;
    }

    rotate() {
        this.bot.editStatus('online', {
            name: `${this.bot.config.prefix}help | [${this.bot.guilds.size}] | ${Games[~~(Math.random() * Games.length)]}`,
            type: 0
        });
        
        setInterval(() => {
            this.rotate();
        }, 60000);
    }
}