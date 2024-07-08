import { defineConfig } from 'vite'

const base = process.env.DEPLOY_ENV === 'staging' ? '/software-engineering-lab/stg-exp-1/' : '/software-engineering-lab/exp-1/'

export default defineConfig({
  base
})
