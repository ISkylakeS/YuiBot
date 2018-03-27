const Command = require('../../structures/BaseCommand');

module.exports = class GithubCommand extends Command {
    constructor(bot) {
        super(bot, {
            name: 'github',
            desc: 'Search a github repository',
            usage: 'github [<user:str>] [<repo_name:str>]',
            aliases: ['git'],
            category: 'Search',
            examples: 'github ohlookitsAugust Yui'
        });
    }

    async run(msg, args) {
        if (!args[0] || !args[1]) return msg.channel.createMessage(`:hehe: \`|\` Usage: \`${this.bot.config.prefix}${this.options.usage}\``);
        const message = await msg.channel.createMessage(':mag: `|` Searching for `' + args[0] + '/' + args[1] + '`');

        try {
            const { body: repo } = await this.bot._snek.get(`https://api.github.com/repos/${args[0]}/${args[1]}`);
            const { body: commits } = await this.bot._snek.get(`https://api.github.com/repos/${args[0]}/${args[1]}/commits?per_page=3`);
            message.edit({ embed: {
                title: repo.full_name,
                url: `https://github.com/${args[0]}/${args[1]}`,
                description: `${repo.desription || 'No description.'}`,
                fields: [{
                    name: "Github Hashes",
                    value: `${commits.map((c) => '[`' + c.sha.substring(0, 7) + '`](' + c.commit.url + ') **' + c.commit.message + '**').join('\n')}`
                },
                {
                    name: "Owner",
                    value: repo.login,
                    inline: true
                },
                {
                    name: 'Primary Language',
                    value: repo.language,
                    inline: true
                },
                {
                    name: "Repo Size",
                    value: (repo.size / 1024).toFixed() + "MB",
                    inline: true
                },
                {
                    name: "Created at",
                    value: new Date(repo.created_at).toDateString(),
                    inline: true
                }],
                color: this.bot.utils.colour()
            }});
        } catch(err) {
            if (err.status === 404) return message.edit(':x: `|` No results founded.');
            message.edit(':x: `|` Error: `' + err.message + '`, try again later.');
        }
    }
}