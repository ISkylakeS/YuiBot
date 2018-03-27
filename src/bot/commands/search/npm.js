const Command = require('../../structures/BaseCommand');

module.exports = class NPMCommand extends Command {
    constructor(bot) {
        super(bot, {
            name: 'npm',
            desc: 'Search a npm package from the npm registry.',
            usage: 'npm [package:str]',
            category: 'Search',
            examples: ['npm sj.reggol']
        });
    }

    async run(msg, args) {
        if (!args[0]) return msg.channel.createMessage(`:hehe: \`|\` Usage: \`${this.bot.config.prefix}${this.options.usage}\``);
        const message = await msg.channel.createMessage(':mag: `|` Searching for `' + args[0] + '`...');
        
        try {
            const { body } = await this.bot._snek.get(`https://registry.npmjs.com/${args[0]}`);
            const version = body.versions[body['dist-tags'].latest];
            const maintainers = this.bot.utils.trimArray(body.maintainers.map(u => u.name));
            const deps = version.dependencies ? this.bot.utils.trimArray(Object.keys(version.dependencies)) : null;
            await message.edit({ embed: {
                title: body.name,
                url: `https://www.npmjs.com/package/${args[0]}`,
                description: `${body.description || 'No description.'}`,
                fields: [{
                    name: '❯ Version',
                    value: body['dist-tags'].latest,
                    inline: true
                },
                {
                    name: "❯ License",
                    value: body.license || 'No license...',
                    inline: true
                },
                {
                    name: "❯ Author of the package",
                    value: body.author ? body.author.name : 'Unknown author?',
                    inline: true
                },
                {
                    name: "❯ Created at",
                    value: new Date(body.time.created).toDateString(),
                    inline: true
                },
                {
                    name: "❯ Modified at",
                    value: new Date(body.time.modified).toDateString(),
                    inline: true
                },
                {
                    name: "❯ Main file",
                    value: version.main || 'index.js',
                    inline: true
                },
                {
                    name: "❯ Dependencies",
                    value: deps && deps.length ? deps.join(', ') : 'No dependencies (Lightweight)',
                    inline: true
                },
                {
                    name: "❯ Maintainers",
                    value: maintainers.join(', '),
                    inline: true
                }],
                color: this.bot.utils.colour()
            }});
        } catch(err) {
            if (err.status === 404) return message.edit(':hmmmm: `|` No results found.');
            return message.edit(":x: `|` Error: `" + err.message + "`, My suggestion is to try again!");
            this.bot.log.error(err.stack);
        }
    }
}