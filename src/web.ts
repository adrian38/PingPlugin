import { WebPlugin } from '@capacitor/core';

import type { PingPluginPlugin } from './definitions';

export class PingPluginWeb extends WebPlugin implements PingPluginPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
