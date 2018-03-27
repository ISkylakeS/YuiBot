module.exports = class Gearbox {
    constructor(bot) {
        this.bot = bot
    }

    /**
     * Post a message to the Gearbox channel; if unhandledRejection has occured!
     * 
     * @param {Error} err The Node.js Error Paramter
     */
    _report(err) {
        this.bot.createMessage('426101490411896842', {
            embed: {
                title: "Yui Hirasawa - Gearbox Report",
                description: `\`\`\`js\n${err.stack}\`\`\``,
                color: this.bot.utils.colour()
            }
        });
    }
}